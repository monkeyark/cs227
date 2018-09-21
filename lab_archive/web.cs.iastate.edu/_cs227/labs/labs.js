
function ExpandCollapse(region, regionTag)
{
  el = document.getElementById(region); 
  el2 = document.getElementById(regionTag); 
  str = el2.textContent.replace(/\s*$/,"");
  if(el.style.display == 'none')
  { 
    el.style.display = ''; 
    el2.textContent =  str.substring(0, str.length - 15) + '(Click to hide)';
  }
  else
  { 
    el.style.display = 'none'; 
    el2.textContent =  str.substring(0, str.length - 15) + '(Click to show)';

  } 

  return false; 
}

function expandOrCollapse(event)
{
  try
  {
  var el = this.querySelector(".expandableContent");

  var el2 = this.querySelector(".expandableTag");
  //el = document.getElementById(region); 
  //el2 = document.getElementById(regionTag); 
  str = el2.textContent.replace(/\s*$/,"");
  if(el.style.display == 'none')
  { 
    el.style.display = ''; 
    el2.textContent =  str.substring(0, str.length - 15) + '(Click to hide)';
  }
  else
  { 
    el.style.display = 'none'; 
    el2.textContent =  str.substring(0, str.length - 15) + '(Click to show)';

  } 
}
catch(e)
{
  console.log("catch block");
}
}

function foo(event)
{
  console.log(event.srcElement);
}
// If javascript is enabled, this will hide all the expandable portions
function init()
{
  var list = document.querySelectorAll(".expandableTag");
  console.log(list.length);     
  for (var i = 0; i < list.length; ++i)
  {
    var item = list[i];
    console.log(item.textContent);
    var str = item.textContent.replace(/\s*$/,"");
    item.textContent = str + ' (Click to show)';
  }
  list = document.querySelectorAll(".expandableContent");
  console.log(list.length);     
  for (var i = 0; i < list.length; ++i)
  {
    var item = list[i];
    item.style.display = 'none'; 
  }

  list = document.querySelectorAll(".expandable");
  console.log(list.length);     
  for (var i = 0; i < list.length; ++i)
  {
    var item = list[i];
    item.onclick = expandOrCollapse;
  }

  list = document.querySelectorAll(".expandable_code");
  console.log(list.length);     
  for (var i = 0; i < list.length; ++i)
  {
    var item = list[i];
    item.onclick = expandOrCollapse;
  }

}

window.onload = init;

