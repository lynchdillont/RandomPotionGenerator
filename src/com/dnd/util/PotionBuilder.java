/**
 * Copyright 2016 Dillon Lynch
 */
package com.dnd.util;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class PotionBuilder {

	private static PotionBuilder potionBuilder;
	
	private XmlAccessor xml;
	private DiceThrower dice;
	
	private PotionBuilder() throws SAXException, IOException, ParserConfigurationException{
		xml = new XmlAccessor();
		dice = new DiceThrower();
	}
	
	public static PotionBuilder getInstance() throws SAXException, IOException, ParserConfigurationException{
		if(potionBuilder == null){
			potionBuilder = new PotionBuilder();
			return potionBuilder;
		} else {
			return potionBuilder;
		}
	}
	
	public String buildPotion(){
		StringBuilder sb = new StringBuilder();
		sb.append("This potion is a(n) ");
		int titleRoll = dice.throwD10();
		String title = xml.getPotionAdjective("title", titleRoll);
		sb.append(title + " of ");
		
		int effectRoll = dice.throwD100();
		String effect = xml.getPotionAdjective("effect", effectRoll);
		sb.append(effect + "\n");
		
		sb.append("The potion's strength is ");
		
		int strengthRoll = dice.throwD10();
		String strength = xml.getPotionAdjective("potentcy", strengthRoll);
		sb.append(strength + "\n");
		
		sb.append("The potion also causes ");
		
		int sideEffectRoll = dice.throwD100();
		String sideEffect = xml.getPotionAdjective("side-effect", sideEffectRoll);
		sb.append(sideEffect + "\n");
		
		sb.append("The potion comes in ");
		
		int containerRoll = dice.throwD20();
		String container = xml.getPotionAdjective("container", containerRoll);
		sb.append(container.substring(0, container.length()-1));
		
		sb.append(" and appears ");
		
		int appearanceRoll = dice.throwD20();
		String appearance = xml.getPotionAdjective("appearance", appearanceRoll);
		sb.append(appearance.substring(0, appearance.length()-1));
		
		sb.append(" with ");
		
		int withRoll = dice.throwD20();
		String with = xml.getPotionAdjective("with", withRoll);
		sb.append(with + "\n");
		
		sb.append("The potion has a(n) ");
		
		int textureRoll = dice.throwD10();
		String texture = xml.getPotionAdjective("texture", textureRoll);
		sb.append(texture.substring(0, texture.length()-1) + " texture" + "\n");
		
		sb.append("The potion smells like ");
		
		int smellRoll = dice.throwD100();
		int tasteRoll = dice.throwD100();
		String smell = xml.getPotionAdjective("smell-taste", smellRoll);
		String taste = xml.getPotionAdjective("smell-taste", tasteRoll);
		sb.append(smell.substring(0, smell.length()-1) + " but tastes like " + taste + "\n");
		
		sb.append("The potion's label: ");
		
		int labelRoll = dice.throwD100();
		String label = xml.getPotionAdjective("label", labelRoll);
		sb.append(label);
		
		System.out.println(sb.toString());
		return sb.toString();
		
	}
	
}
