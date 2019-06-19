package ufjf.dcc193.tr2;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ufjf.dcc193.tr2.dao.AreaConhecimentoRepository;
import ufjf.dcc193.tr2.dao.AvaliadorRepository;
import ufjf.dcc193.tr2.dao.RevisaoRepository;
import ufjf.dcc193.tr2.dao.TrabalhoRepository;
import ufjf.dcc193.tr2.model.AreaConhecimento;
import ufjf.dcc193.tr2.model.Avaliador;
import ufjf.dcc193.tr2.model.Revisao;
import ufjf.dcc193.tr2.model.Trabalho;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	AreaConhecimentoRepository areaConhecimentoRep;

	@Autowired
	AvaliadorRepository avaliadorRep;

	@Autowired
	TrabalhoRepository trabalhoRep;

	@Autowired
	RevisaoRepository revisaoRep;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/*
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
			trabalhoRep.save(new Trabalho(null, "Fisica 1", "Mecanica Aplicada", "indira.ice.ufjf.br",
					areaConhecimentoRep.findById(1L).get()));
			trabalhoRep.save(new Trabalho(null, "Vida Marinha", "Fisiologia dos tubaroes", "bio.ufjf.br",
					areaConhecimentoRep.findById(2L).get()));
			trabalhoRep.save(new Trabalho(null, "Lages Pré-moldadas", "Civil Aplicada", "civil.ufjf.br",
					areaConhecimentoRep.findById(3L).get()));
			trabalhoRep.save(new Trabalho(null, "Pronto Socorro", "Medicina 1", "med.ufjf.br",
					areaConhecimentoRep.findById(4L).get()));
			trabalhoRep.save(new Trabalho(null, "Sociologia 1", "Sociedade Moderna 1", "social.ufjf.br",
					areaConhecimentoRep.findById(5L).get()));
			trabalhoRep.save(new Trabalho(null, "Direito Penal", "Penal 1", "dir.ufjf.br",
					areaConhecimentoRep.findById(6L).get()));
			trabalhoRep.save(new Trabalho(null, "Inglês 1", "Moderna 1", "let.ufjf.br",
					areaConhecimentoRep.findById(7L).get()));
			avaliadorRep.save(new Avaliador(null, "Gabriel Nascimento", "gabriel.nascimento@ice.ufjf.br", "avalia@2019",
					Collections.unmodifiableList(Arrays.asList(areaConhecimentoRep.findById(1L).get(),
					 areaConhecimentoRep.findById(2L).get(),
					 areaConhecimentoRep.findById(3L).get(),
					 areaConhecimentoRep.findById(4L).get(),
					 areaConhecimentoRep.findById(5L).get(),
					 areaConhecimentoRep.findById(6L).get(),
					 areaConhecimentoRep.findById(7L).get()
					 ))));
			revisaoRep.save(new Revisao(avaliadorRep.findAll().get(0),
					 trabalhoRep.findAll().get(0), 2, "Olimpiada de fisica", 1));		 
		};
		*/
	}

}
