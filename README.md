# 스프링 의 기초인 aop 와 di 의 기본예시

+ IoC 컨테이너
  ioc 는 inversion of controller 의 약자로 이는 제어의 역전을 뜻한다.  
  보통의 프로그램에서는 객체를 프로그래머가 제어(생성, 파괴, ..) 하게 되어있다.  
  그러나 제어의 역전으로 인해 이러한 작업은 ioc 컨테이너가 대신 해주게 된다.  
  스프링에서는 객체를 빈으로 등록하고 등록된 빈을 알맞은 dependency에 injection 해준다.  
  

+ aop  
  aop는 관점 지향 프로그래밍 방식으로 공통 모듈을 여러 코드에 적용하기 쉽게 도와주는 방식이다.
  기존에는 공통 관심사항을 적용할 때 코드 앞뒤로 적어주었는데 이는 코드의 양을 증가시키고 유지보수를 어렵게 만든다는 단점이 있었다.
  aop는 라이브러리가 공통 기능을 알맞게 삽입해 주기 때문에 일일이 코드로 적어줄 필요가 없다.
  
  
### Dependency Injection  

------------------  

Animal.xml  
```
<bean id="dog" class="config.Dog">
    <property name="myName" value="poodle"></property>
</bean>  
```
xml 을 통해 빈을 직접 등록  
property 의 name은 setName을 호출한다 이는 다음 과 같다.  
```
setName(poodle);
```
생성자에서 다른 빈을 필요로 하는 경우.  
```
<bean id="petOwner" class="config.PetOwner">
    <constructor-arg ref="cat"/>
</bean>
```
설정파일을 기반으로 어플리케이션 컨텍스트를 만들고 빈을 얻기.  
```
ApplicationContext applicationContext = new ClassPathXmlApplicationContext("config/Animal.xml");
PetOwner petOwmer = applicationContext.getBean("petOwner",PetOwner.class);
petOwmer.play();
```

### AOP  
---------------------  

Profiler.java  
```
public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{  
  ...  
  try{  
    Object result = joinPoint.proceed();  
	  return result;  
  }finally{  
  ...  
  }  
}
```


  
