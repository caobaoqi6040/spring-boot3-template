package dev.caobaoqi6040.backend.config;

import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.support.config.FastJsonConfig;
import com.alibaba.fastjson2.support.spring.http.converter.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * FastJsonConfiguration
 *
 * @author caobaoqi6040
 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer
 * @since 2025/9/3 16:56
 */
@Configuration
public class FastJsonConfiguration implements WebMvcConfigurer {

	private final List<MediaType> SUPPORTED_MEDIA_TYPES = Arrays.asList(
		MediaType.APPLICATION_JSON,
		MediaType.APPLICATION_ATOM_XML,
		MediaType.APPLICATION_FORM_URLENCODED,
		MediaType.APPLICATION_OCTET_STREAM,
		MediaType.APPLICATION_PDF,
		MediaType.APPLICATION_RSS_XML,
		MediaType.APPLICATION_XHTML_XML,
		MediaType.APPLICATION_XML,
		MediaType.IMAGE_GIF,
		MediaType.IMAGE_JPEG,
		MediaType.IMAGE_PNG,
		MediaType.TEXT_EVENT_STREAM,
		MediaType.TEXT_HTML,
		MediaType.TEXT_MARKDOWN,
		MediaType.TEXT_PLAIN,
		MediaType.TEXT_XML
	);

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();

		converter.setFastJsonConfig(fastJsonConfigure());
		converter.setSupportedMediaTypes(SUPPORTED_MEDIA_TYPES);

		converters.add(0, converter);
	}

	private FastJsonConfig fastJsonConfigure() {
		FastJsonConfig config = new FastJsonConfig();

		config.setDateFormat("yyyy-MM-dd HH:mm:ss");
		config.setCharset(StandardCharsets.UTF_8);
		config.setWriterFeatures(
			JSONWriter.Feature.WriteNullListAsEmpty,
			JSONWriter.Feature.PrettyFormat,
			JSONWriter.Feature.WriteMapNullValue,
			JSONWriter.Feature.WriteNullBooleanAsFalse,
			JSONWriter.Feature.WriteNullNumberAsZero,
			JSONWriter.Feature.WriteNullStringAsEmpty,
			JSONWriter.Feature.MapSortField
		);
		return config;
	}
}
