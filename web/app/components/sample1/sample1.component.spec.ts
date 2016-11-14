/* tslint:disable:no-unused-variable */

import { TestBed, async } from '@angular/core/testing';
import {  Sample1Component } from './sample1.component';

describe('App: Sample1', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [
        Sample1Component
      ],
    });
  });

  it('should create the app', async(() => {
    let fixture = TestBed.createComponent( Sample1Component);
    let app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  }));

  it(`should have as value 'It is a bright new day!!!'`, async(() => {
    let fixture = TestBed.createComponent( Sample1Component);
    let app = fixture.debugElement.componentInstance;
    expect(app.title).toEqual('app works!');
  }));

  it('should render value in a h2 tag', async(() => {
    let fixture = TestBed.createComponent( Sample1Component);
    fixture.detectChanges();
    let compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('h2').textContent).toContain('new day!!!');
  }));
});
