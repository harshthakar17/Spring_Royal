<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h2>Box Cricket Registration</h2>
		
		<form action="savereg" method="Post">
			Name: <input type="text" name= "studentName" value="${studentNameValue}"/>
			<span style="color:red">${studentNameError}</span>
			<br><br>
			
			Playing Type :
				Batsman <input type="radio" name="playerType" value="Batsman"  ${reg.playerType == 'Batsman' ? 'checked' : ''} />
		
				Bowler <input type="radio" name="playerType" value="Bowler"  ${reg.playerType == 'Bowler' ? 'checked' : ''}/>
				
				AllRounder <input type="radio" name="playerType" value="AllRounder"  ${reg.playerType == 'AllRounder' ? 'checked' : ''}/>
				${playerTypeError}
				<br><br>
				
			
			Food Preference :
				
				<select name="foodPreference">
					<option value="-1">-----Select your food preference----</option>
					<option value="Regular" ${reg.foodPreference == 'Regular' ? 'selected' : ''} >Regular</option>
					<option value="Jain"  ${reg.foodPreference == 'Jain' ? 'selected' : ''}>Jain</option>
				</select>
				${foodPreferenceError} <br><br>
				
			Drink:
				RB <input type="checkbox" name="drink" value="rb" ${reg.drink.contains('rb')?'checked':'' }/>
				MD <input type="checkbox" name="drink" value="md" ${reg.drink.contains('md')?'checked':''}/>
				TH <input type="checkbox" name="drink" value="th" ${reg.drink.contains('th')?'checked':''}/>
				LJ <input type="checkbox" name="drink" value="lj" ${reg.drink.contains('lj')?'checked':''}/>
				CO <input type="checkbox" name="drink" value="co" ${reg.drink.contains('co')?'checked':''}/>
		${drinkError}
		<br><br>
				<input type="submit" value="Register"/>
		
		</form>
</body>
</html>