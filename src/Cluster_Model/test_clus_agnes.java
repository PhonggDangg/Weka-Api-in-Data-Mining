package Cluster_Model;

import weka.core.Instances;

public class test_clus_agnes {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Cluster_Data cluster = new Cluster_Data();
		Instances data = cluster.loadData("D:\\Infinity\\ChuanbiHK6\\Khai thác dữ liệu và ứng dụng\\Chính\\Databases\\buy_remove_id.csv.arff");
		cluster.build_clusters_Agnes(data, 2, "SINGLE");
		System.out.println(cluster.output());
		Instances data_uncluster = cluster.loadData("D:\\Infinity\\ChuanbiHK6\\Khai thác dữ liệu và ứng dụng\\Chính\\Databases\\buy_remove_id.csv.arff");
		cluster.predict_cluster(data_uncluster);	
	}

}
