package Classification_Model;

import weka.core.Instances;

public class Test_Model {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Instances data_train, data_test;
		Classification_Data classify_nv = new Classification_Data();
		data_train =  classify_nv.loadData("C:\\Program Files\\Weka-3-8-6\\data\\diabetes.arff");
		classify_nv.build_Classification_NaiveBayes(data_train);
		System.out.println(classify_nv.out_model());
		data_test = classify_nv.loadData("D:\\Infinity\\ChuanbiHK6\\Khai thác dữ liệu và ứng dụng\\Chính\\Databases\\diabetes_test.arff");
		classify_nv.evaluation_model(data_test, 5); 
		System.out.println(classify_nv.out_evaluation());
	}

}
