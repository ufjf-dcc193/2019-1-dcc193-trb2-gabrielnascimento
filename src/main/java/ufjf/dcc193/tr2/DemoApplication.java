package ufjf.dcc193.tr2;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ufjf.dcc193.tr2.dao.AreaConhecimentoRepository;
import ufjf.dcc193.tr2.model.AreaConhecimento;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	AreaConhecimentoRepository areaConhecimentoRep;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			areaConhecimentoRep.save(new AreaConhecimento(null, "Exatas"));
			areaConhecimentoRep.save(new AreaConhecimento(null, "Biologia"));
			areaConhecimentoRep.save(new AreaConhecimento(null, "Engenharia"));
			areaConhecimentoRep.save(new AreaConhecimento(null, "Saúde"));
			areaConhecimentoRep.save(new AreaConhecimento(null, "Socias"));
			areaConhecimentoRep.save(new AreaConhecimento(null, "Humanas"));
			areaConhecimentoRep.save(new AreaConhecimento(null, "Letras"));

		};
	}

}
