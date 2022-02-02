package springbootCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import springbootCrud.model.Kisi;
import springbootCrud.repository.KisiRepository;

@Service
public class KisiService {
	
public static KisiRepository kisiRepository;
	
//Dependency Injection bunu yapmayıp klasik yöntemle çağırsaydık birbirine sıkı sıkı bağlı olacaktı, birinin
	//ömrü ötekine bağlı oluyor,biri oluşmadan diğeri oluşturulamıyor ve kolay ayrılmıyor
	@Autowired// Spring buna ihtiyaç duyduğunda (çalıştırıldığında), oluşturuyor, alttaki tetiklenmeden boşuna çalışmasın diye.
	public KisiService(KisiRepository kisiRepo) {
		KisiService.kisiRepository = kisiRepo;
	}
	
	//veritabanına kisi ekleyen servis metodu
	
	public Kisi kisiEkle(Kisi kisi)
	{
		return kisiRepository.save(kisi); //repos. jpa sayesinde database e kisi verileri kaydoldu
		
	}
	
	//database den tüm listeyi getir
	public List<Kisi> tumKisileriGetir(){
		return kisiRepository.findAll();
		
	}
	
	// id ile kisi silme
	
	public String idIleKisiSil(Integer id ) {
		
		if(kisiRepository.findById(id)==null) {
			
			throw new EmptyResultDataAccessException(id);
			}
		
		kisiRepository.deleteById(id);
		return id + " id li kisi silindi";
	}
	
	

}
