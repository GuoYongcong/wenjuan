package com.gyc.wenjuan.admin.config;

import com.alibaba.druid.support.http.WebStatFilter;

/**   
 * 配置监控拦截器, druid监控拦截器   
 */    
//@WebFilter(filterName="druidWebStatFilter",    
//urlPatterns="/*",    
//initParams={    
//    @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*"), // 忽略资源    
//})   
public class DruidStatFilter extends WebStatFilter {  

} 