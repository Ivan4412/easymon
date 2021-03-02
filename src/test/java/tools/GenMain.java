package tools;

/**
 * 生产数据操作层代码
 */

public class GenMain {
	public static void main(String[] args) {
		String configFile = "/generatorConfig.xml";
		try {
			String[] tableNames = new String[] {"t_receiver", "t_datasource", "t_monit_rule", "t_rule_receiver", "t_monit_Log","t_common_req","t_configuration"};
			GenMybatisFiles.gen(configFile, tableNames);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
