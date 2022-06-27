package Cluster_Model;

import WekaJava.Preprocess_Data;
import weka.clusterers.HierarchicalClusterer;
import weka.clusterers.SimpleKMeans;
import weka.core.EuclideanDistance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SelectedTag;

public class Cluster_Data extends Preprocess_Data {

	SimpleKMeans kmeans;
	HierarchicalClusterer agnes;
	
	public void build_cluster_kmeans (Instances data, int k) throws Exception
	{
		kmeans = new SimpleKMeans();
		kmeans.setNumClusters(k);
		kmeans.setDistanceFunction(new EuclideanDistance());
		kmeans.buildClusterer(data);
	}
	
	public void Cluster_label(Instances data) throws Exception
	{
		for(int i=0; i<data.numInstances();i++)
		{
			int num_Cluster = kmeans.clusterInstance(data.instance(i));
			System.out.println("Instance" + (i+1)+ ": " + num_Cluster);
		}
	}
	
	public void cluster_label (Instances data) throws Exception
	{
		for(int i = 0; i < data.numInstances();i++)
		{
			int num_cluster = kmeans.clusterInstance(data.instance(i));
			System.out.println("Instance" + (i+1)+ ": "+num_cluster);
		}
	}
	
	public String out_cluster_data()
	{
		return kmeans.toString();
	}
	
	public void build_clusters_Agnes (Instances data, int k, String type) throws Exception
	{
		agnes = new HierarchicalClusterer();
		agnes.setDistanceFunction(new EuclideanDistance());
		agnes.setLinkType(new SelectedTag(type, HierarchicalClusterer.TAGS_LINK_TYPE));
		agnes.buildClusterer(data);
	}
	
	public void predict_cluster (Instances data) throws Exception
	{
		for (Instance instance : data)
		{
			int numcluster = agnes.clusterInstance(instance);
			System.out.println(instance.toString() + "thuoc cum" + numcluster);
		}
	}
	
	public String output()
	{
		return agnes.toString();
	}
}
