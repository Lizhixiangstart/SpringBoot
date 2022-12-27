package com.example.boot05web01.converter;

import com.example.boot05web01.bean.Person;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
/*
* 自定义Converter
* */
public class GuiguMessageConverter implements HttpMessageConverter<Person> {


    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        //判断条件为Person类及其子类
        return Person.class.isAssignableFrom(clazz);
    }
    /*
    * 服务器要统计所有的MessageConverter都能转换哪些类型的数据
    * */
    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return MediaType.parseMediaTypes("application/x-guigu");//返回支持的MediaType
    }

    @Override
    public Person read(Class<? extends Person> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    public void write(Person person, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        //自定义协商数据的写出
        String data = person.getUserName()+";"+person.getAge()+";"+person.getBirth();

        //写出去
        OutputStream body = outputMessage.getBody();
        body.write(data.getBytes("GBK"));
    }



}
