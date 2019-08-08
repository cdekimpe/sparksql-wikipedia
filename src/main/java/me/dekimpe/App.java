package me.dekimpe;

import java.io.IOException;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        
        /*SparkSession spark = SparkSession
                .builder()
                .appName("Java Spark test")
                .getOrCreate();
        
        Dataset<Row> df = spark.read().format("xml").load("hdfs://stub-meta-history/stub-meta-history1.xml");*/
        
        System.out.println( "Hello World!" );
    }
}
