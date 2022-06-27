package Classification_Model;

import WekaJava.Preprocess_Data;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Debug.Random;
import weka.core.Instances;
import weka.core.pmml.jaxbbindings.DecisionTree;

public class J48_Classification extends Preprocess_Data{
	J48 j48;
	Evaluation evl ;
	private Instances test_data;
	private Instances train_data;
	
	public void build_Classification_DecisionTree (Instances data) throws Exception 
	{
		this.train_data = data;
		train_data.setClassIndex(train_data.numAttributes()-1);
		j48 = new J48();
		j48.buildClassifier(train_data);
	}
	
	
	public void evl_Classification_DecisionTree(Instances data, int k) throws Exception 
	{
		this.test_data = data;
		test_data.setClassIndex(test_data.numAttributes()-1);
		Random rd = new Random(1);
		evl = new Evaluation(train_data);
		evl.crossValidateModel(j48, data, k, rd);
	}
	
	public String  out_J48_model()
	{
		return j48.toString();
	}
	
}
