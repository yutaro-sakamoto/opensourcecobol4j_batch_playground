all:
	mvn clean dependency:copy-dependencies -DoutputDirectory=lib package

run:
	java -cp 'target/batch-1.0.0-SNAPSHOT.jar:lib/*' \
	org.springframework.batch.core.launch.support.CommandLineJobRunner \
	META-INF/jobs/job01.xml job01

#cbl:
#cd src/main/java/com/example/batch/job01 && cobj CobolTasklet1.cbl && rm *.class

.PHONY: run
