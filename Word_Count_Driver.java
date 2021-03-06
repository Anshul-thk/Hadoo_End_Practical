import java.io.IOException;

// file system 
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

// box classes import 
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

// mapreduce imports
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Word_Count_Driver {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

		Job j = new Job();
		j.setJobName("My First Job");
		j.setJarByClass(Word_Count_Driver.class);
		j.setMapperClass(Word_Count_Mapper.class);
		j.setReducerClass(Word_Count_Reducer.class);
		j.setOutputKeyClass(Text.class);
		j.setOutputValueClass(IntWritable.class);

		FileInputFormat.addInputPath(j, new Path(args[0]));
		FileOutputFormat.setOutputPath(j, new Path(args[1]));

		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}

}
