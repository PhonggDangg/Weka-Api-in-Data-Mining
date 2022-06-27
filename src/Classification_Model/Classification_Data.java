package Classification_Model;


import WekaJava.Preprocess_Data;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Debug;
import weka.core.Debug.Random;
import weka.core.Instances;

public class Classification_Data extends Preprocess_Data{
	NaiveBayes nv;
	Evaluation evl;
	
	public void build_Classification_NaiveBayes(Instances data ) throws Exception
	{
		data.setClassIndex(data.numAttributes()-1);
		nv = new NaiveBayes();
		nv.buildClassifier(data);
		
	}
	
	public void evaluation_model(Instances data, int k) throws Exception
	{
		data.setClassIndex(data.numAttributes()-1);
		evl = new Evaluation(data);
		Debug.Random rd = new Debug.Random(1);
		evl.crossValidateModel(nv, data, k, rd);
	}
	
	public String out_model()
	{
		return nv.toString();
	}
	
	public String out_evaluation() throws Exception
	{
		return evl.toSummaryString() + "\n" + evl.toMatrixString();
	}
	
}
