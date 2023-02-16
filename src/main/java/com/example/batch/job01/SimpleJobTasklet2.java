package com.example.batch.job01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class SimpleJobTasklet2 implements Tasklet {
    private static final Logger logger = LoggerFactory.getLogger(SimpleJobTasklet2.class);

    @Override
    public RepeatStatus execute(StepContribution conribution, ChunkContext chunkContext) throws Exception {
        logger.info("called tasklet2.");
        return RepeatStatus.FINISHED;
    }
}