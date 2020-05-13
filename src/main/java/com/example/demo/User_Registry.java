package com.example.demo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(uniqueConstraints= {
		@UniqueConstraint(columnNames = {"user_id", "registry_id"})
})
public class User_Registry {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "registry_id")
	private Registry registry;
	
	private LocalDateTime registeredAt;
	
	@ApiModelProperty(notes = "Posición en la lista de favoritos", name="favorito", required=false, value="1")
	private int favorito;
	@ApiModelProperty(notes = "Posición en la lista de recomendables", name="recomendable", required=false, value="1")
	private int recomendable;
	
	private String notes;

	public User_Registry() {
		
	}
	
	public User_Registry(User user, Registry registry, int favorito, int recomendable, String notes) {
		super();
		this.user = user;
		this.registry = registry;
		this.favorito = favorito;
		this.recomendable = recomendable;
		this.notes = notes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Registry getRegistry() {
		return registry;
	}

	public void setRegistry(Registry registry) {
		this.registry = registry;
	}

	public LocalDateTime getRegisteredAt() {
		return registeredAt;
	}

	public void setRegisteredAt(LocalDateTime registeredAt) {
		this.registeredAt = registeredAt;
	}

	public int getFavorito() {
		return favorito;
	}

	public void setFavorito(int favorito) {
		this.favorito = favorito;
	}

	public int getRecomendable() {
		return recomendable;
	}

	public void setRecomendable(int recomendable) {
		this.recomendable = recomendable;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "User_Registry [id=" + id + ", user=" + user + ", registry=" + registry + ", registeredAt="
				+ registeredAt + ", favorito=" + favorito + ", recomendable=" + recomendable + ", notes=" + notes + "]";
	}
	
	
}
