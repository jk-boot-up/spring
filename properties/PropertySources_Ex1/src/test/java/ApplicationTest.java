import com.explore.jk.spring.config.AppConfig;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@TestPropertySource("classpath:test.properties")
public class ApplicationTest {


    @Test
    public void testReportSubscriber() {

    }
}
