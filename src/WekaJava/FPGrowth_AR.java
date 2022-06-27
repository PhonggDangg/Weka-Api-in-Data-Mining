package WekaJava;

import weka.associations.FPGrowth;

public class FPGrowth_AR extends Preprocess_Data{
	FPGrowth fpg;
	String[] option_model_fpg;
	
	public void mine_AR_FPG(String opt) throws Exception 
	{
		this.option_model_fpg = weka.core.Utils.splitOptions(opt);
		fpg = new FPGrowth();
		fpg.setOptions(option_model_fpg);
		fpg.buildAssociations(dataset);
//		fpg.setFindAllRulesForSupportLevel(true);
	}
	
	public String Output_AR_FPG()
	{
		return fpg.toString();
	}
}
