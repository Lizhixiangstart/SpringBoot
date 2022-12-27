package com.example.boot05web01.config;

import com.example.boot05web01.bean.Pet;
import com.example.boot05web01.converter.GuiguMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
* 配置WebConfigur接口实现类用于支持矩阵变量
*
* */
@Configuration(proxyBeanMethods = false)
public class WebConfig /*implements WebMvcConfigurer*/ {

    @Bean("filter")//HiddenHttpMethodFilter配置用于支持表单发送DELETE、PUT请求
    public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
        HiddenHttpMethodFilter methodFilter = new HiddenHttpMethodFilter();
        methodFilter.setMethodParam("小胖nmsl");
        return methodFilter;
    }

    /*@Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }*/

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
        /*
        * 自定义内容协商策略
        * */
            @Override//配置内容协商
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                HashMap<String, MediaType> mediaType = new HashMap<>();
                mediaType.put("json",MediaType.APPLICATION_JSON);
                mediaType.put("xml",MediaType.APPLICATION_XML);
                mediaType.put("gg",MediaType.parseMediaType("application/x-guigu"));
                //支持解析哪些参数对应的哪些媒体类型
                    //参数内容协商策略
                ParameterContentNegotiationStrategy parameterStrategy = new ParameterContentNegotiationStrategy(mediaType);
                //parameterStrategy.setParameterName("ff");
                    //请求头内容协商策略
                HeaderContentNegotiationStrategy headStrategy = new HeaderContentNegotiationStrategy();
                //configure调用strategies方法添加自定义的参数内容协商策略和请求头内容协商策略
                configurer.strategies(Arrays.asList(parameterStrategy,headStrategy));

            }

            //扩展MessageConverter（将自定义MessageConverter添加进容器中）
            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                converters.add(new GuiguMessageConverter());
            }

            //配置矩形变量
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }

            //添加表单格式化器，用于格式化表单
            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, Pet>() {
                    @Override
                    public Pet convert(String source) {
                        //小胖,3
                        if (StringUtils.isEmpty(source)){
                            Pet pet = new Pet();
                            String[] split = source.split(",");
                            pet.setName(split[0]);
                            pet.setAge(Integer.parseInt(split[1]));
                        }
                        return null;
                    }
                });
            }

        };
    }
}
