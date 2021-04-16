<#import "parts/shell.ftl" as s>

<@s.page>
     <div class="columns">
          <div class="column">
               <#include "parts/personage/table_personage.ftl">
          </div>

          <div class="column">
               <#include "parts/personage/about_personage.ftl">
          </div>
     </div>
</@s.page>