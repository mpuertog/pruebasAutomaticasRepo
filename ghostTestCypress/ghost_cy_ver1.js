describe('Ghost under monkeys', function() {
    it('visits ghost and survives monkeys', function() {
        cy.visit('https://ghost.org/es/');
        cy.wait(2000);
        randomTest(100);
    })
})
function getRandomInt(min, max) {
        min = Math.ceil(min);
        max = Math.floor(max);
        return Math.floor(Math.random() * (max - min)) + min;
    };

function randomTest(monkeysLeft) {
    if(monkeysLeft > 0) {
      var testEjec = getRandomInt(1,2);
      switch(testEjec){
        case 1:
          cy.get('a').then($links => {
                var randomLink = $links.get(getRandomInt(0, $links.length));
                if(!Cypress.dom.isHidden(randomLink)) {
                    cy.wrap(randomLink).click({force: true});
                    monkeysLeft = monkeysLeft - 1;
                }
                cy.wait(2000);
                randomTest(monkeysLeft);
          });
          break;
        case 2:
          cy.get('span').then($Buttons => {
              var randomButton = $Buttons.get(getRandomInt(0, $Buttons.length));
              if(!Cypress.dom.isHidden(randomButton)) {
                  cy.wrap(randomButton).click({force: true});
                  monkeysLeft = monkeysLeft - 1;
              }
              cy.wait(2000);
              randomTest(monkeysLeft);
          });
          break;
        }
    }
}