document.addEventListener('DOMContentLoaded', function(){
  fetch('/api/profile').then(r=>r.json()).then(profile=>{
    document.getElementById('name').textContent = profile.name || 'Anand';
    document.getElementById('heroName').innerHTML = `Hi, I'm <span id="name">${profile.name}</span>!`;
    document.getElementById('tagline').textContent = profile.title || profile.bio || '';
    const avatar = document.getElementById('avatarImg');
    if(profile.avatarUrl) avatar.src = profile.avatarUrl;
  }).catch(()=>{});

  fetch('/api/projects').then(r=>r.json()).then(projects=>{
    const container = document.getElementById('projectsList');
    if(!projects || !projects.length){ container.innerHTML = '<p>No projects yet — coming soon.</p>'; return; }
    projects.forEach(p=>{
      const card = document.createElement('div'); card.className='project-card';
      card.innerHTML = `<h3>${p.title}</h3><p>${p.description}</p><p style="font-size:13px;color:rgba(0,0,0,0.55)"><strong>Tech:</strong> ${p.tech || ''}</p>`;
      container.appendChild(card);
    });
  }).catch(()=>{});

  // contact form
  const form = document.getElementById('contactForm');
  if(form){
    form.addEventListener('submit', function(e){
      e.preventDefault();
      const payload = {
        name: document.getElementById('nameInput').value,
        email: document.getElementById('emailInput').value,
        message: document.getElementById('messageInput').value
      };
      fetch('/api/contact', {method:'POST', headers:{'content-type':'application/json'}, body:JSON.stringify(payload)})
        .then(r=>r.json()).then(data=>{
          document.getElementById('contactStatus').textContent = 'Message sent — thank you!';
          form.reset();
        }).catch(()=> document.getElementById('contactStatus').textContent = 'Error sending message');
    });
  }

  document.getElementById('year').textContent = new Date().getFullYear();
});
