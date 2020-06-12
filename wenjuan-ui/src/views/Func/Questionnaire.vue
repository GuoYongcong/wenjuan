<template>
  <div class="container" style="width:99%;margin-top:-25px;">
  <!--工具栏-->
  <div class="toolbar" style="float:left;padding-top:10px;padding-left:15px;">
    <el-form :inline="true" :model="filters" :size="size">
      <el-form-item>
        <el-input v-model="filters.label" placeholder="名称"></el-input>
      </el-form-item>
      <el-form-item>
        <kt-button :label="$t('action.search')" perms="func:questionnaire:view" type="primary" @click="findPage(null)"/>
      </el-form-item>
      <el-form-item>
        <kt-button :label="$t('action.add')" perms="func:questionnaire:add" type="primary" @click="handleAdd" />
      </el-form-item>
    </el-form>
  </div>
  <!--表格内容栏-->
  <kt-table permsEdit="func:questionnaire:edit" permsDelete="func:questionnaire:delete"
    :data="pageResult" :columns="columns"
    @findPage="findPage" @handleEdit="handleEdit" @handleDelete="handleDelete">
  </kt-table>
  <!--新增编辑界面-->
  <el-dialog :title="operation?'新增':'编辑'" width="60%" :visible.sync="editDialogVisible" :close-on-click-modal="false" :before-close="onCancel">
    <el-form :model="dataForm" label-width="100px" ref="dataForm" :size="size" >
      <el-form-item label="问卷标题" prop="title" :rules="[{ required: true, message: '请输入问卷标题', trigger: 'blur' }]">
        <el-input v-model="dataForm.title" auto-complete="off" type="textarea" maxlength="50" show-word-limit autosize></el-input>
      </el-form-item>

      <div v-for="(que, queIndex) in dataForm.questions" :key="'question'+queIndex">
        <el-card shadow="hover">
          <el-form-item :label="'题目' + (queIndex+1)" :prop="'questions.'+queIndex+'.title'" :rules="[{ required: true, message: '请输入题目标题', trigger: 'blur' }]">
            <el-col :span="20">
              <el-input v-model="que.title" auto-complete="off" type="textarea" maxlength="100" show-word-limit autosize></el-input>
            </el-col>
            <el-col :span="2">
              <el-button type="danger" icon="el-icon-delete" @click="deleteQuestion(queIndex)"></el-button>
            </el-col>
          </el-form-item>
          <el-form-item label="类型">
            <el-col :span="5">
              <el-radio-group v-model="que.type">
                <el-radio-button label="0">单选</el-radio-button>
                <el-radio-button label="1">多选</el-radio-button>
              </el-radio-group>
            </el-col>
          </el-form-item>
          <div v-for="(opt, optIndex) in que.options" :key="'option'+optIndex">
            <el-row :gutter="24">
              <el-col :span="18" :offset="2">
                <el-form-item :label="'选项'+(optIndex+1)" :prop="'questions.'+queIndex+'.options.'+optIndex+'.content'" :rules="[{ required: true, message: '请输入选项内容', trigger: 'blur' }]">
                  <el-input v-model="opt.content" auto-complete="off" type="textarea" maxlength="50" show-word-limit autosize></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="2">
                <el-button type="primary" icon="el-icon-plus" @click="addOption(queIndex)" circle plain></el-button>
              </el-col>
              <el-col :span="1">
                <el-button type="danger" icon="el-icon-minus" @click="deleteOption(queIndex, optIndex)" circle plain></el-button>
              </el-col>
            </el-row>
          </div>
        </el-card>
      </div>
      <el-button type="primary" icon="el-icon-circle-plus-outline" @click="addQustion" plain>添加题目</el-button>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button :size="size" @click.native="onCancel">{{$t('action.cancel')}}</el-button>
      <el-button :size="size" type="primary" @click.native="submitForm" :loading="editLoading">{{$t('action.submit')}}</el-button>
    </div>
  </el-dialog>
  </div>
</template>

<script>
import KtTable from "@/views/Core/KtTable"
import KtButton from "@/views/Core/KtButton"
import { format } from "@/utils/datetime"
export default {
  components:{
      KtTable,
      KtButton
  },
  data() {
    return {
      size: 'small',
      filters: {
        label: ''
      },
      columns: [
        {prop:"id", label:"编号", minWidth:100},
        {prop:"title", label:"问卷标题", minWidth:100},
        {prop:"userId", label:"用户编号", minWidth:100},
        {prop:"state", label:"问卷状态：0表示未发布；1表示已发布", minWidth:100},
      ],
      pageRequest: { pageNum: 1, pageSize: 8 },
      pageResult: {},

      operation: false, // true:新增, false:编辑
      editDialogVisible: false, // 新增编辑界面是否显示
      editLoading: false,
      // 新增编辑界面数据
      dataForm: {
        id: null,
        title: '',
        userId: null,
        state: 0,
        questions: []
      },
      question: {
        id: null,
        title: '',
        userId: null,
        state: 0,
        questions: []
      }
    }
  },
  methods: {
    // 获取分页数据
    findPage: function (data) {
      if(data !== null) {
        this.pageRequest = data.pageRequest
      }
      this.pageRequest.columnFilters = {label: {name:'label', value:this.filters.label}}
      this.$api.questionnaire.findPage(this.pageRequest).then((res) => {
        this.pageResult = res.data
      }).then(data!=null?data.callback:'')
    },
    // 批量删除
    handleDelete: function (data) {
      this.$api.questionnaire.batchDelete(data.params).then(data!=null?data.callback:'')
    },
    // 显示新增界面
    handleAdd: function () {
      this.editDialogVisible = true
      this.operation = true
      this.dataForm = {
        id: null,
        title: '',
        userId: null,
        state: 0,
        questions: []
      }
    },
    // 显示编辑界面
    handleEdit: function (params) {
      this.editDialogVisible = true
      this.operation = false
      this.dataForm = Object.assign({}, params.row)
    },
    //添加题目
    addQustion: function(){
      let length = this.dataForm.questions.length
      let question = {
        id: null,
        questionnaireId: null,
        type: 0,
        title: '',
        no: 1,
        options: []
      }
      if(length === 0)
        question.no = 1
      else
        question.no = this.dataForm.questions[length-1].no + 1
      this.dataForm.questions.push(question)
      //题目默认添加两个选项
      for(let i = 0; i < 2; i++)
        this.addOption(length)
    },
    //删除题目
    deleteQuestion: function(index){
      this.dataForm.questions.splice(index, 1)
    },
    //添加选项
    addOption: function(index){
      let length = this.dataForm.questions[index].options.length
      let option = {
        id: null,
        questionId: null,
        no: 1,
        content: ''
      }
      if(length === 0)
        option.no = 1
      else
        option.no = this.dataForm.questions[index].options[length-1].no + 1
      this.dataForm.questions[index].options.push(option)
    },
    //删除选项
    deleteOption: function(queIndex, optIndex){
      if(this.dataForm.questions[queIndex].options.length === 2){
        this.$message({ message: '删除失败，一个题目至少保留两个选项！', type: 'error' })
        return
      }
      this.dataForm.questions[queIndex].options.splice(optIndex, 1)
    },
    // 编辑
    submitForm: function () {
      this.$refs.dataForm.validate((valid) => {
        if (valid) {
          this.$confirm('确认提交吗？', '提示', {}).then(() => {
            this.editLoading = true
            let params = Object.assign({}, this.dataForm)
            this.$api.questionnaire.save(params).then((res) => {
              if(res.code == 200) {
                this.$message({ message: '操作成功', type: 'success' })
                console.log("questionnaireId,"+res.data);
              } else {
                this.$message({message: '操作失败, ' + res.msg, type: 'error'})
              }
              this.editLoading = false
              this.$refs['dataForm'].resetFields()
              this.editDialogVisible = false
              this.findPage(null)
            })
          })
        }
      })
    },
    onCancel: function(){
      this.$confirm('确认放弃保存问卷吗？', '提示', {}).then(() => {
        this.editDialogVisible = false
      })
    },
    // 时间格式化
        dateFormat: function (row, column, cellValue, index){
            return format(row[column.property])
        }
  },
  mounted() {
  }
}
</script>

<style>
.el-card{
  margin-bottom: 20px;
}
</style>
