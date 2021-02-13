package test.la;

import logic.beans.SpotBean;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import logic.beans.ShopBean;
import logic.beans.SignUpBean;


public class BeanTest 
{

		
		@Test
		public void testSpotBean()
		{
			SpotBean bean = new SpotBean("spot","via","17","Roma","Roma","area");
			bean.control("skatepark","descrizione");
			assertEquals(true,bean.check());
		}
		
		@Test
		public void testShopBean()
		{
			ShopBean bean = new ShopBean("shop","Roma","11111111111","Roma","area","descrizione");
			bean.control("street","12");
			assertEquals(true,bean.check());
		}
		
		@Test
		public void testSignUpBean()
		{
			SignUpBean bean = new SignUpBean("Lorenzo","Amoretti","lolloSkate","email@test.com","password","password");
			bean.control(LocalDate.of(1999, 6, 9),"M","Owner");
			assertEquals(true,bean.check());
		}
}
