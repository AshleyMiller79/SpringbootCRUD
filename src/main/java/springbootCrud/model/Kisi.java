package springbootCrud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="kisiler")
@Data //parametreli cons+ getter setter +toString
@NoArgsConstructor // parametresiz constructor
public class Kisi {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//id otomatik olsun
	private Integer id;
	
	private String ad;
	
	private String soyad;
	
	private int yas;
	
	}
