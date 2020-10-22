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
  
trace 메서드는 특정 Joinpoint(advice를 적용 가능 지점) 에서 실행 될 공통기능을 정의하는 메서드이다.  
공통기능을 제공할 클래스를 작성하고 xml 파일에 Aspect(공통기능)를 설정한다.

setting.xml  
```
...  
<bean id="profiler" class="aop.Profiler"/>
...  
<aop:config>
	<aop:aspect id="traceAspect" ref="profiler">
		<aop:pointcut expression="execution(public * aop..*(..))" id="publicMethod"/>
		<aop:around pointcut-ref="publicMethod" method="trace"/>
	</aop:aspect>
</aop:config>
```
먼저 공통기능을 정의한 클래스를 빈으로 등록해준다.  
pointcut 의 표현식은 정규표현식이나 aspectJ문법을 통해 설정 할 수 있다.  
위 설정내용에 따르면 aop 패키지 안에 존재하는 모든 public method는 적용 대상이다.  
around advice로 적용되며 trace 메소드를 사용한다.  
around advice는 가장 범용적으로 사용되며 대상 객체의 메소드 실행 전/후 익셉션 발생 시에 적용할 수 있는 advice 이다.  
