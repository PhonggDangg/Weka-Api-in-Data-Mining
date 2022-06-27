package WekaJava;

import java.io.File;
import java.io.IOException;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NominalToBinary;
import weka.filters.unsupervised.attribute.NumericToBinary;
import weka.filters.unsupervised.attribute.NumericToNominal;
import weka.filters.unsupervised.attribute.Remove;

public class Preprocess_Data {
	DataSource source;
	protected Instances dataset;
	String[] option_data;
	
	public Instances loadData(String filename) throws Exception
	{
		this.source = new DataSource(filename);
		this.dataset = source.getDataSet() ;
		return dataset;
	}
	
	public void convertNu2No(String opt) throws Exception
	{
		NumericToNominal nutono = new NumericToNominal();
		this.option_data = weka.core.Utils.splitOptions(opt);
		nutono.setOptions(option_data);
		nutono.setInputFormat(this.dataset);
		this.dataset = Filter.useFilter(this.dataset, nutono);
	}
	
	public void convertNo2Bi(String opt) throws Exception
	{
		NominalToBinary notobi = new NominalToBinary();
		this.option_data = weka.core.Utils.splitOptions(opt);
		notobi.setOptions(option_data);
		notobi.setInputFormat(this.dataset);
//		notobi.setBinaryAttributesNominal(true);
		this.dataset = Filter.useFilter(this.dataset, notobi);
	}
	
	public void convertNu2Bi(String opt) throws Exception
	{
		NumericToBinary nutobi = new NumericToBinary();
		this.option_data = weka.core.Utils.splitOptions(opt);
		nutobi.setOptions(option_data);
		nutobi.setInputFormat(dataset);
		this.dataset = Filter.useFilter(dataset, nutobi);
	}
	
	public void remove (String opt) throws Exception
	{
		Remove rm = new Remove();
		this.option_data = weka.core.Utils.splitOptions(opt);
		rm.setOptions(option_data);
		rm.setInputFormat(this.dataset);
		this.dataset = Filter.useFilter(this.dataset, rm);
	}
	
	public void saveData_ARFF(String filename) throws IOException
	{
		ArffSaver arff_file = new ArffSaver();
		arff_file.setInstances(this.dataset);
		arff_file.setFile(new File(filename));
		arff_file.writeBatch();
	}
	
	public void saveData_ARFF_CSV(String filename) throws IOException
	{
		CSVSaver save_file = new CSVSaver();
		save_file.setInstances(this.dataset);
		save_file.setFile(new File(filename));
		save_file.writeBatch();
	}
	public String outData()
	{
		return dataset.toSummaryString();
	}
}











