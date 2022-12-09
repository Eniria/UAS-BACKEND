package UAS.BackEnd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_matakuliah")
public class Matakuliah {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, name = "kode_matakuliah", length = 2)
  private String code;
  
  @Column(nullable = false, name = "nama_matakuliah", length = 2)
  private String name;

  @Column(nullable = false, name = "dosenPengajar_matakuliah")
  private String dosen_pengajar;

  @ManyToOne
  private Mahasiswa mahasiswa;
}
