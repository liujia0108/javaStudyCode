package constant;

import java.util.HashMap;
import java.util.Map;

public class AppStore {

	public static final String APPSTORE_NAME = "应用市场";
	public static final String APPMRG_NAME = "应用管理";
	public static final String APPNULL = "没有可卸载应用，快去安装吧";
	public static final String BUTTON_OPEN = "打开";
	public static final String BUTTON_INSTALL = "安装";
	public static final String RECOMMONED = "推荐";
	public static final String SEARCH = "搜索";
	public static final String APPUPDATE = "应用更新";
	//HashMap用来保存应用推荐列表中的所有应用的信息，Key为应用名，Value为应用对应的包名。可以根据页面推荐的应用不同而随时修改。
	public static final Map<String,String> map = new HashMap<String,String>();
	static
	{
		map.put("唯品会", "com.vipshop.tv.shopping");
		map.put("三国杀传奇", "com.bf.sgscqtv");
		map.put("贝瓦儿歌", "com.slanissue.tv.erge");
		map.put("宝石三国", "com.trans.gem");
		map.put("快乐学堂-小学生", "com.edufound.ott.xx");
		map.put("三国杀神将传", "com.holyblade.sjz.game");
		map.put("熊猫国学", "air.gx.android.common.A123qibu.com");
		map.put("有乐斗地主", "com.youjoy.strugglelandlord");
	}	
}
