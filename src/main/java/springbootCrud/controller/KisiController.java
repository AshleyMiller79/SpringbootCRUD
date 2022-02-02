package springbootCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import springbootCrud.model.Kisi;
import springbootCrud.service.KisiService;

@RestController //parent controller her türlü mapping kullanılabilir bu anotasyonla
public class KisiController {


	public  KisiService kisiService;
	
	@Autowired //biz yazınca değil lazım olduğunda oluştur. alttaki gibi yaparak sıkı sıkı
	//bağlanmalarını engelledik, yeri geldiğinde birbirinden bağımsız olsun diye.
	//dependency injection yaptık, controller ın içine service yi injekte ettik
	public KisiController(KisiService kisiService) {
		this.kisiService = kisiService;
	}
	
	
	@GetMapping(path="/kisiler") // bu bir get işlemi old için requestmapping (bütün mappingleri kaplayan anotasyon)
	//değilde get işlemine özel olan @GetMapping anotasyonunu kullandık
	public List<Kisi> fetchPerson(){
		return kisiService.tumKisileriGetir();//kisiService class ındaki tumKisileriGetir metoduna git, o da db den verileri döndürsün
		
		
	}
	
	@PostMapping(path="/kisiler/ekle")
	public Kisi addPerson( @RequestBody   Kisi kisi) {//@RequestBody model de oluşan toplu bir veri geliyor
		
		return kisiService.kisiEkle(kisi);
	}
	
	@DeleteMapping(path="/kisiler/sil/{id}") //frontend e id girerek sil butonuna basmak=/kisiler/sil/{id} bunu localhosta yazmak demek .
	public String deletePersonWithId(@PathVariable  Integer id) {
		
		
		return kisiService.idIleKisiSil(id);
	}
	
	
}
