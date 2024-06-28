package com.batch.teste.teste.batch.TableStep;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.batch.teste.teste.model.TestTable;

@Configuration
public class TableStepReader {
	
	@Bean
	@StepScope
	public ItemReader<TestTable> getTableStepReader(DataSource dataSource){
		return new JdbcCursorItemReaderBuilder<TestTable>()
				.name("getTableStepReader")
				.dataSource(dataSource)
				.sql("select * from TestTable")
				.beanRowMapper(TestTable.class)
				.build();
	}

	/*
	 * 
	 * @Bean
	@StepScope
	public FlatFileItemReader<ViacepResponse> getValidCepStepReader(@Value("#{jobParameters['nomeArquivo']}") Resource fileResource) throws InternalError{
		String[] columnsArray = {"cep"};
		if(!fileResource.exists()) throw new InternalError("Arquivo não encontrado");
		return new FlatFileItemReaderBuilder<ViacepResponse>()
				.name("getValidCepStepReader")
				.resource(fileResource)
				.delimited()
				.names(columnsArray)
				.targetType(ViacepResponse.class)
				.build();
	}
	 * 
	 */
	
}
