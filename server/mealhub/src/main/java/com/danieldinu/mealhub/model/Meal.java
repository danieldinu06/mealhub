package com.danieldinu.mealhub.model;

import com.danieldinu.mealhub.model.baseModel.Element;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "meals")
@Entity
@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class Meal extends Element {
}
