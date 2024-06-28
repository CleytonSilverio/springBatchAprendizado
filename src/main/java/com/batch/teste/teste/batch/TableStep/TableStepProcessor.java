package com.batch.teste.teste.batch.TableStep;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.batch.teste.teste.model.TestTable;
import com.batch.teste.teste.repository.TestTableRepository;

@Configuration
public class TableStepProcessor {

	@Bean
	public ItemProcessor<TestTable, TestTable> getProcessor(TestTableRepository data) {
		return null;
	}
	
//	private Validator<TestTable> validator(){
//		return new Validator<TestTable>(){
//			@Override
//			public void validate(TestTable value) throws ValidationException {
//				
//			}
//		};
//	}


}
