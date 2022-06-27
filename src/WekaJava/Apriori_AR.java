package WekaJava;

import weka.associations.Apriori;

public class Apriori_AR extends Preprocess_Data{
	Apriori apriori;
	String[] option_model;
	
	public void Mine_AR_Apriori(String opt) throws Exception
	{
		this.option_model = weka.core.Utils.splitOptions(opt);
		apriori = new Apriori();
		apriori.setOptions(option_model);
		apriori.setOutputItemSets(true);
		apriori.buildAssociations(dataset);
	}
	
	public String output_AR_Apriori()
	{
		return apriori.toString();
	}
}
