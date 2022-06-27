package Cluster_Model;

import weka.core.Instances;

public class Test_Cluster_Model {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Cluster_Data kmeans = new Cluster_Data();
		Instances data = kmeans.loadData("D:\\Infinity\\ChuanbiHK6\\Khai thác dữ liệu và ứng dụng\\Chính\\Databases\\buy_remove_id.csv.arff");
		kmeans.build_cluster_kmeans(data, 3);
		System.out.println(kmeans.out_cluster_data());
		kmeans.cluster_label(data);
	}

}
