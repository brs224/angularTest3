import { Component } from '@angular/core';
import '../../public/css/styles.css';
import {  Sample1Component } from  './components/sample1/sample1.component'
@Component({
  selector: 'my-app',
  template: require('./app.component.html'),
  styles: [require('./app.component.css')]
})
export class AppComponent {
  title = 'Hello World66';
}