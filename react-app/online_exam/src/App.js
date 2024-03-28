import logo from './logo.svg';
import './App.css';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import { Button, ListGroup, ListGroupItem } from 'react-bootstrap';
import { useEffect, useState } from 'react';



function App() {
  const[minutes,setMinutes] = useState(60);
  const[seconds,setSeconds] = useState(60);

  const showTimer=()=>{
    const deadline = new Date();
    deadline.setHours(deadline.getHours()+1);        
    setInterval(()=>{   
      const time = deadline - Date.now();   
      setMinutes(Math.floor((time / 1000 / 60) % 60));
      setSeconds(Math.floor((time / 1000) % 60));
    },1000);
  }
   

  useEffect(()=>showTimer(),[]);
  let questionsArray = [
    {
      'question':"Lorem ipsum dolor sit amet consectetur adipisicing elit. bAccusamus natus, dicta a cupiditate tempora recusandae doloribus pariatur reiciendis quas nisi nesciunt at, quia officiis nam error eligendi repellendus quaerat ipsum!",
      "option1":"Option1",
      "option2":"Option2",
      "option3":"Option3",
      "option4":"Option4",
    },
    {
      'question':"Lorem ipsum dolor sit amet consectetur adipisicing elit. bAccusamus natus, dicta a cupiditate tempora recusandae doloribus pariatur reiciendis quas nisi nesciunt at, quia officiis nam error eligendi repellendus quaerat ipsum!",
      "option1":"Option1",
      "option2":"Option2",
      "option3":"Option3",
      "option4":"Option4",
    },
    {
      'question':"Lorem ipsum dolor sit amet consectetur adipisicing elit. bAccusamus natus, dicta a cupiditate tempora recusandae doloribus pariatur reiciendis quas nisi nesciunt at, quia officiis nam error eligendi repellendus quaerat ipsum!",
      "option1":"Option1",
      "option2":"Option2",
      "option3":"Option3",
      "option4":"Option4",
    },
    {
      'question':"Lorem ipsum dolor sit amet consectetur adipisicing elit. bAccusamus natus, dicta a cupiditate tempora recusandae doloribus pariatur reiciendis quas nisi nesciunt at, quia officiis nam error eligendi repellendus quaerat ipsum!",
      "option1":"Option1",
      "option2":"Option2",
      "option3":"Option3",
      "option4":"Option4",
    },{
      'question':"Lorem ipsum dolor sit amet consectetur adipisicing elit. bAccusamus natus, dicta a cupiditate tempora recusandae doloribus pariatur reiciendis quas nisi nesciunt at, quia officiis nam error eligendi repellendus quaerat ipsum!",
      "option1":"Option1",
      "option2":"Option2",
      "option3":"Option3",
      "option4":"Option4",
    },{
      'question':"Lorem ipsum dolor sit amet consectetur adipisicing elit. bAccusamus natus, dicta a cupiditate tempora recusandae doloribus pariatur reiciendis quas nisi nesciunt at, quia officiis nam error eligendi repellendus quaerat ipsum!",
      "option1":"Option1",
      "option2":"Option2",
      "option3":"Option3",
      "option4":"Option4",
    },{
      'question':"Lorem ipsum dolor sit amet consectetur adipisicing elit. bAccusamus natus, dicta a cupiditate tempora recusandae doloribus pariatur reiciendis quas nisi nesciunt at, quia officiis nam error eligendi repellendus quaerat ipsum!",
      "option1":"Option1",
      "option2":"Option2",
      "option3":"Option3",
      "option4":"Option4",
    },{
      'question':"Lorem ipsum dolor sit amet consectetur adipisicing elit. bAccusamus natus, dicta a cupiditate tempora recusandae doloribus pariatur reiciendis quas nisi nesciunt at, quia officiis nam error eligendi repellendus quaerat ipsum!",
      "option1":"Option1",
      "option2":"Option2",
      "option3":"Option3",
      "option4":"Option4",
    },{
      'question':"Lorem ipsum dolor sit amet consectetur adipisicing elit. bAccusamus natus, dicta a cupiditate tempora recusandae doloribus pariatur reiciendis quas nisi nesciunt at, quia officiis nam error eligendi repellendus quaerat ipsum!",
      "option1":"Option1",
      "option2":"Option2",
      "option3":"Option3",
      "option4":"Option4",
    },{
      'question':"Lorem ipsum dolor sit amet consectetur adipisicing elit. bAccusamus natus, dicta a cupiditate tempora recusandae doloribus pariatur reiciendis quas nisi nesciunt at, quia officiis nam error eligendi repellendus quaerat ipsum!",
      "option1":"Option1",
      "option2":"Option2",
      "option3":"Option3",
      "option4":"Option4",
    },{
      'question':"Lorem ipsum dolor sit amet consectetur adipisicing elit. bAccusamus natus, dicta a cupiditate tempora recusandae doloribus pariatur reiciendis quas nisi nesciunt at, quia officiis nam error eligendi repellendus quaerat ipsum!",
      "option1":"Option1",
      "option2":"Option2",
      "option3":"Option3",
      "option4":"Option4",
    },{
      'question':"Lorem ipsum dolor sit amet consectetur adipisicing elit. bAccusamus natus, dicta a cupiditate tempora recusandae doloribus pariatur reiciendis quas nisi nesciunt at, quia officiis nam error eligendi repellendus quaerat ipsum!",
      "option1":"Option1",
      "option2":"Option2",
      "option3":"Option3",
      "option4":"Option4",
    }
  ]
  return (
      <Container>
      <Row>
          <Col>
              <h1>Exam online</h1>
          </Col>
          <Col className=' text-end'>
              <h1>{minutes}:{seconds}</h1>
          </Col>
      </Row>
      <Row>
        <Col>
       
          {
            questionsArray.map((obj,index)=>{
              return(
                <ListGroup key={index}>
                   <ListGroupItem className='list-group-item-primary'>
                    {obj.question}
                  </ListGroupItem>
                  <ListGroupItem>
                    <input type="radio"/>   {obj.option1}
                  </ListGroupItem>
                  <ListGroupItem>
                    <input type="radio"/>   {obj.option2}
                  </ListGroupItem>
                 <ListGroupItem>
                    <input type="radio"/>   {obj.option3}
                  </ListGroupItem>
                  <ListGroupItem>
                    <input type="radio"/>   {obj.option4}
                  </ListGroupItem>
            </ListGroup>
              )
            })
          }
         
        </Col>
      </Row>
      <Row>
        <Col className='text-end'>
        <Button variant="primary" className='m-2'>Save</Button>
      <Button variant="secondary">Cancel</Button>
        </Col>
      </Row>
    </Container>
  );
}

export default App;
