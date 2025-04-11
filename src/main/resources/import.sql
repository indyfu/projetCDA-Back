INSERT INTO user(name, surname, login, password) VALUES ('Laura', 'LELOIRE', 'admin', '$2a$10$hce1.H3he1D4EVP8i7txjuKiSG61LB.eoFLIv9puxMZ1s38lW.eem')
INSERT INTO user(name, surname, login, password) VALUES ('Arvydas', 'Ze RV', 'RV', '$2a$10$EZk5FwPHFjSfYAckbXXxx.0lg4eiWmWeo1nw7yfZ1ydC1a6GRrcpa')

INSERT INTO role (role_name) VALUE('ADMIN'), ('USER');
INSERT INTO Style (style_dress) VALUES ('PRINCESS');
INSERT INTO Style (style_dress) VALUES ('SIRENE');
INSERT INTO Style (style_dress) VALUES ('VINTAGE');
INSERT INTO Style (style_dress) VALUES ('ROMANTIQUE');
INSERT INTO Style (style_dress) VALUES ('MODERN');
INSERT INTO Style (style_dress) VALUES ('CLASSIQUE');
INSERT INTO Style (style_dress) VALUES ('CHIC');
INSERT INTO Style (style_dress) VALUES ('COCKTAIL');
INSERT INTO Style (style_dress) VALUES ('DRAPPED');
INSERT INTO Style (style_dress) VALUES ('LACE');

INSERT INTO dress ( name, prix, style_id, image, image_alt1, image_alt2, description) VALUES ( 'Hestia', '3000', '1', 'pictures/Hestia/Hestia 03.JPG', 'pictures/Hestia/Hestia 06.JPG', 'pictures/Hestia/Hestia 01.JPG','Robe princesse de rêve. Métamorphose en conte de fées. Corsage ajusté, jupe ample, dentelle, perles. Promesse d''amour éternel. Soyez une reine d''un jour');
INSERT INTO dress ( name, prix, style_id, image, image_alt1, image_alt2, description) VALUES ( 'Héra', '1500', '4', 'pictures/Héra/Héra 07.JPG','pictures/Héra/Héra 06.JPG', 'pictures/Héra/Héra 01.JPG', 'Robe romantique, jardin secret d''amour. Tissus légers, dentelle délicate, poésie de rêve. Danse de regards, promesse éternelle. Muse d''un amour infini.');
INSERT INTO dress ( name, prix, style_id, image, image_alt1, image_alt2, description) VALUES ( 'Aphrodite', '2000', '2', 'pictures/Aphrodite/Aphrodite 10.JPG','pictures/Aphrodite/Aphrodite 08.JPG', 'pictures/Aphrodite/Aphrodite 11.JPG', 'Robe romantique, jardin secret d''amour. Tissus légers, dentelle délicate, poésie de rêve. Danse de regards, promesse éternelle. Muse d''un amour infini.');
INSERT INTO dress ( name, prix, style_id, image, image_alt1, image_alt2, description) VALUES ( 'Théia', '1500', '4', 'pictures/Théia/Théia 05.JPG','pictures/Théia/Théia 03.JPG', 'pictures/Théia/Théia 06.JPG', 'Robe romantique, jardin secret d''amour. Tissus légers, dentelle délicate, poésie de rêve. Danse de regards, promesse éternelle. Muse d''un amour infini.');

INSERT INTO Status (status_name) VALUES ('EN_ATTENTE');
INSERT INTO Status (status_name) VALUES ('ACCEPTE');
INSERT INTO Status (status_name) VALUES ('REFUSE');
INSERT INTO Status (status_name) VALUES ('ANNULE');
INSERT INTO Status (status_name) VALUES ('DEVIS_DISPO');
INSERT INTO Status (status_name) VALUES ('EN_CREATION');
INSERT INTO Status (status_name) VALUES ('TERMINE');

INSERT INTO user_roles (user_id, roles_id) VALUES (1,1)
INSERT INTO user_roles (user_id, roles_id) VALUES (2,1)