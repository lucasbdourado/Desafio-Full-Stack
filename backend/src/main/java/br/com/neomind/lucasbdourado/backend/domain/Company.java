package br.com.neomind.lucasbdourado.backend.domain;

import br.com.neomind.lucasbdourado.backend.annotation.FieldValidation;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name = "companies")
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_seq")
    @SequenceGenerator(name = "company_seq", sequenceName = "seq_company", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @FieldValidation("validateEmail")
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "comment", nullable = false)
    private String comment;

    @FieldValidation("validateCnpj")
    @Column(name = "cnpj", nullable = false, unique = true)
    private String cnpj;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String formatCnpj(){
        return cnpj.replaceFirst("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
    }

    public Boolean validateEmail() throws Exception {
        try{
            String regex = "^[A-Za-z0-9+_.-]+@(.+)$";

            Pattern pattern = Pattern.compile(regex);

            Matcher matcher = pattern.matcher(email);

            if (matcher.matches()) {
                return true;
            } else {
                throw new Exception("Por favor, informe um e-mail válido. Ex: neomind@teste.com");
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public Boolean validateCnpj() throws Exception {
        try{
            String regex = "^\\d{2}(\\.\\d{3}){2}/\\d{4}-\\d{2}$|^\\d{14}$";

            Pattern pattern = Pattern.compile(regex);

            Matcher matcher = pattern.matcher(cnpj);

            if (matcher.matches()) {
                cnpj = formatCnpj();

                return true;
            } else {
                throw new Exception("Por favor, informe um cnpj válido. Ex: 00.000.000/000-00 ou 0000000000000");
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
