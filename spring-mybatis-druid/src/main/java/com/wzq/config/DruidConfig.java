/*
 * Copyright [2018]
 * 顺丰科技开源(opensource@sfmail.sf-express.com)
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wzq.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 类描述:
 * Druid配置
 *
 * @author 顺丰科技开源(opensource @ sfmail.sf - express.com)
 * @version 1.0.0
 * @date 2018-11-29 14:12
 */
@Configuration
public class DruidConfig {

    @Bean
    public ServletRegistrationBean druidServlet() { // 主要实现WEB监控的配置处理
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*"); // 进行druid监控的配置处理操作
        servletRegistrationBean.addInitParameter("allow",
                "127.0.0.1,192.168.1.1"); // 白名单
        servletRegistrationBean.addInitParameter("deny", "192.168.1.200"); // 黑名单
        servletRegistrationBean.addInitParameter("loginUsername", "admin"); // 用户名
        servletRegistrationBean.addInitParameter("loginPassword", "admin"); // 密码
        servletRegistrationBean.addInitParameter("resetEnable", "false"); // 是否可以重置数据源
        return servletRegistrationBean ;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean() ;
        filterRegistrationBean.setFilter(new WebStatFilter());

        filterRegistrationBean.addUrlPatterns("/*"); // 所有请求进行监控处理
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.css,/druid/*");
        return filterRegistrationBean ;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }
}