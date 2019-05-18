package service;

import bean.Hitokoto;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HitokotoService implements IHitokotoService {

	private List<Hitokoto> hitokotos;
	private Random random = new Random();

	// 一言数据来源 https://international.v1.hitokoto.cn/?c=d
	public HitokotoService() {
		hitokotos = new ArrayList<>();
		hitokotos.add(new Hitokoto("这个天地，我来过，我奋战过，我深爱过，我不在乎结局。", "悟空传"));
		hitokotos.add(new Hitokoto( "“太阳快落下去了，你们的孩子居然不害怕？”“当然不害怕，她知道明天太阳还会升起来的。”", "三体II"));
		hitokotos.add(new Hitokoto( "只有用心灵才能看得清事物本质，真正重要的东西是肉眼无法看见的", "小王子"));
		hitokotos.add(new Hitokoto( "我是个偶尔会发疯的人啊！", "龙族"));
		hitokotos.add(new Hitokoto( "凛冬将至", "冰与火之歌"));
		hitokotos.add(new Hitokoto( "蓝曦臣，我这一生害人无数，杀父杀兄杀妻杀子杀师杀友，天下的坏事我什么没做过！......可我独独没有想过要害你", "魔道祖师"));
		hitokotos.add(new Hitokoto("我要拼，装上假牙也要拼！", "灌篮高手"));
		hitokotos.add(new Hitokoto("情不知所起，一往而深，生者可以死，死者可以生，生而不可与死，死而不可复生者，皆非情之至也。", "杜丹亭"));
		hitokotos.add(new Hitokoto("未老已衰之石，未冷已冻之水，未生已死之身，未灼已化之魂。", "镇魂"));
	}

	@Override
	public Hitokoto random() {
		return hitokotos.get(random.nextInt(hitokotos.size()));
	}
}
