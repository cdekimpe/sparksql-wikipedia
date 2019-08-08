package me.dekimpe;

import java.io.IOException;
import java.sql.SQLException;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, SQLException
    {
        
        if (args.length < 1) {
            System.out.println("Please give the topic in the arguments");
            System.exit(1);
        }
        
        /*SparkSession spark = SparkSession
                .builder()
                .appName("Java Spark test")
                .getOrCreate();
        
        Dataset<Row> df = spark.read().format("xml").load("hdfs://stub-meta-history/stub-meta-history1.xml");*/
        
        System.out.println( "Hello World!" );
        
        NeighborsPages np = new NeighborsPages();
        
        int[] neighbors = np.get(args[0]);
        for (int i = 0; i < neighbors.length; i++) {
           System.out.println(neighbors[i]);
        }
        
    }
}
