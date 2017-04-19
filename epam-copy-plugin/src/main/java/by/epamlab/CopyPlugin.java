package by.epamlab;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "copy", defaultPhase = LifecyclePhase.VALIDATE)
public class CopyPlugin extends AbstractMojo {

	private static final String DEFAULT_PATH_OUTPUT_FILE = "output/my_new.properties";
	private static final String DEFAULT_PATH_INPUT_FILE = "input/my.properties";

	@Parameter(property = "inputPath")
	private String inputPath;

	@Parameter(property = "outputPath")
	private String outputPath;

	public void execute() throws MojoExecutionException {
		if (inputPath == null) {
			getLog().info("NOT SET INPUT PATH IN CONFIGURATION PLUGIN");
			inputPath = DEFAULT_PATH_INPUT_FILE;
			getLog().info("SET DEFAULT INPUT FILE PATH: " + inputPath);
		}else {
			getLog().info("SET INPUTFILE PATH FROM PLUGIN CONFIG: " + inputPath);
		}

		if (outputPath == null) {
			getLog().info("NOT SET OUTPUT PATH IN CONFIGURATION PLUGIN");
			outputPath = DEFAULT_PATH_OUTPUT_FILE;
			getLog().info("SET DEFAULT OUTPUT FILE PATH: " + outputPath);
		}else {
			getLog().info("SET OUTPUTFILE PATH FROM PLUGIN CONFIG: " + outputPath);
		}

		File from = new File(inputPath);
		File to = new File(outputPath);

		if (!from.exists()) {
			getLog().error("INPUT FILE NOT EXIST");
			return;
		}

		to = new File(outputPath);
		to.mkdirs();

		try {
			Files.copy(from.toPath(), to.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			getLog().error("Error copying file" + e.getMessage());
		}
	}

	public String getInputPath() {
		return inputPath;
	}

	public String getOutputPath() {
		return outputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}

	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}

}
