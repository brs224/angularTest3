import { Component } from '@angular/core';

@Component({
  selector: 'sample1',
  template: require('./sample1.component.html'),
  styles: [require('./sample1.component.css')]
})
export class Sample1Component {
  class = 'relative';
  sampleTitle1 = 'It is a bright new day!!!';
}
