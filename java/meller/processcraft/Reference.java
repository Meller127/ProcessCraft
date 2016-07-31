package meller.processcraft;

public class Reference {
	
	public static final String MOD_ID = "proc";
	public static final String NAME = "Processcraft";
	public static final String VERSION = "0.0.1";
	public static final String ACCEPTED_VERSION = "[1.9.4]";
	
	public static final String CLIENT_PROXY_CLASS = "meller.processcraft.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "meller.processcraft.proxy.ServerProxy";
	
	public static enum ProcesscraftItems 
	{
		EXSTOP("exstop", "ItemexStop");
		
		private String unlocalizedName;
		private String registryName;
		
		ProcesscraftItems(String unlocalizedName, String registryName){
			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;
	}
		
		public String getUnlocalizedName() 
		{
			return unlocalizedName;
		}
		
		public String getRegistryName() 
		{
			return registryName;
		}
	}
	
	public static enum ProcesscraftBlocks{
		
		CRUSHER("crusher", "BlockCrusher");
		
		private String unlocalizedName;
		private String registryName;
		
		ProcesscraftBlocks(String unlocalizedName, String registryName){
			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;
		}
		
		public String getUnlocalizedName() 
		{
			return unlocalizedName;
		}
		
		public String getRegistryName() 
		{
			return registryName;
		}
		
	}
}
