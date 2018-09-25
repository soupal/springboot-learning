package com.darren.microboot.serializer;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import com.darren.microboot.pojo.Worker;

// 此时定义的序列化操作可以序列化所有类的对象
public class RedisObjectSerializer implements RedisSerializer<Object> {

	// 为了方便进行对象与字节数组的转换 首先准备两个转换器
	private Converter<Object, byte[]> serialzingConverter = new SerializingConverter();
	private Converter<byte[], Object> derialzingConverter = new DeserializingConverter();
	private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
	
	@Override
	public byte[] serialize(Object object) throws SerializationException {
		if(object == null) {
			return EMPTY_BYTE_ARRAY;
		}
		return this.serialzingConverter.convert(object);
	}
	
	@Override
	public Object deserialize(byte[] data) throws SerializationException {
		if(data == null || data.length == 0) {
			return null;
		}
		return this.derialzingConverter.convert(data);
	}


	public static void main(String[] args) {
		RedisObjectSerializer se = new RedisObjectSerializer();
		Worker member = new Worker();
		member.setMid(100L);
		member.setName("无可奉告");
		member.setSalary(8000.00);
		member.setAge(18);
		try {
			member.setBirthday(new SimpleDateFormat("yyyyMMdd").parse("20001225"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		byte[] data = se.serialize(member);
		System.out.println(se.deserialize(data));
	}

}
