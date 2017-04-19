# maven-plugin-task
Apache Maven plugin development task


Apache Maven plugin development task

Build Apache Maven plugin that allow to copy file between directories.
Required configuration:
-	inputFile
-	outputFile
Deploy developed Maven Plugin to local repo.
Create pom.xml with build section containing execution of developed plugin only.
Plugin should be configured to copy ./input/my.properties file to ./output/my_new.properties
Please follow instructions and conventions provided in Guide java plugin development

# For run plugin:
# mvn clean by.epamlab:epam-copy-plugin:1.0:copy
