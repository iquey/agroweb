import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mx.agroweb.admin.service.LicenciaService;
import com.mx.agroweb.admin.vo.LicenciaVO;

public class SpringTest {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context-admin.xml");
		LicenciaService licenciaService = (LicenciaService) ctx.getBean("licenciaServiceImpl");
		
		LicenciaVO licenciaVO = licenciaService.getLicencia("Kevin", "root");
		
		System.out.println();

	}
}
